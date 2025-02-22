package file.engine.frames;

import file.engine.configs.Constants;
import file.engine.event.handler.EventManagement;
import file.engine.services.TranslateService;
import file.engine.services.download.DownloadManager;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 使用方法：给点击下载的button添加actionListener，判断当前按钮是点击下载，还是点击取消下载
 * 如果是点击取消下载则发送一个cancel请求
 * 如果是点击下载，则通过判断后发送一个start下载请求，然后开启一个线程运行该方法即可
 */
public class SetDownloadProgress {

    /**
     * 当你点击下载按钮时使用，此时isDownloadStarted必须设为true
     *
     * @param labelProgress   显示进度的label
     * @param buttonInstall   设置文字为下载还是取消的下载点击按钮
     * @param downloadManager 下载管理类的实例
     * @param isShowProgress  判断是否需要显示label和button的状态
     * @param successCallback 下载成功后执行方法
     */
    protected static boolean setProgress(JLabel labelProgress,
                                         JButton buttonInstall,
                                         DownloadManager downloadManager,
                                         Supplier<Boolean> isShowProgress,
                                         Runnable successCallback) {
        boolean retVal = false;
        try {
            TranslateService translateService = TranslateService.getInstance();
            EventManagement eventManagement = EventManagement.getInstance();
            String buttonOriginalText = buttonInstall.getText();
            boolean isStarted = true;
            while (isStarted) {
                if (isShowProgress.get()) {
                    if (!eventManagement.notMainExit()) {
                        return true;
                    }
                    if (isShowProgress.get()) {
                        double progress = downloadManager.getDownloadProgress();
                        Constants.Enums.DownloadStatus downloadStatus = downloadManager.getDownloadStatus();
                        if (downloadStatus == Constants.Enums.DownloadStatus.DOWNLOAD_DONE) {
                            //下载完成，禁用按钮
                            labelProgress.setText("");
                            buttonInstall.setText(translateService.getTranslation("Downloaded"));
                            buttonInstall.setEnabled(false);
                            isStarted = false;
                            successCallback.run();
                            retVal = true;
                        } else if (downloadStatus == Constants.Enums.DownloadStatus.DOWNLOAD_ERROR) {
                            //下载错误，重置button
                            labelProgress.setText(translateService.getTranslation("Download failed"));
                            buttonInstall.setText(buttonOriginalText);
                            buttonInstall.setEnabled(true);
                            isStarted = false;
                        } else if (downloadStatus == Constants.Enums.DownloadStatus.DOWNLOAD_DOWNLOADING) {
                            //正在下载
                            labelProgress.setText(translateService.getTranslation("Downloading:") + (int) (progress * 100) + "%");
                            buttonInstall.setText(translateService.getTranslation("Cancel"));
                            buttonInstall.setEnabled(true);
                        } else if (downloadStatus == Constants.Enums.DownloadStatus.DOWNLOAD_INTERRUPTED) {
                            //用户自行中断
                            labelProgress.setText("");
                            buttonInstall.setText(buttonOriginalText);
                            buttonInstall.setEnabled(true);
                            isStarted = false;
                            retVal = true;
                        }
                    }
                }
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return retVal;
    }
}
