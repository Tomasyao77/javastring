package ffmpeg;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-08-10 14:29
 */

public class GetVideoImg {
    public static void main(String[] args) {
        //String inFile = "/home/zouy/WorkSpace/idea_ws/javastring/src/ffmpeg/asset/VID_20180810_142454.mp4",
        //String inFile = "http://ouq6u283u.bkt.clouddn.com/VID_20180810_142454.mp4",
        String inFile = "http://ouq6u283u.bkt.clouddn.com/VID_20180810_142648.mp4",
                outFile = "/home/zouy/WorkSpace/idea_ws/javastring/src/ffmpeg/asset/VID_20180810_142648.jpg";
        transfer(inFile, outFile);
        //clearFiles("/home/zouy/WorkSpace/idea_ws/javastring/src/ffmpeg/asset/VID_20180810_142648.jpg");
    }

    // 视频缩略图截取
    public static boolean transfer(String inFile, String outFile) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/home/zouy/Downloads/ffmpeg/bin/ffmpeg ")//ffmpeg程序
                     .append(" -i ")
                     .append(inFile)//输入视频文件
                     .append(" -y -f image2 ")
                     .append(" -ss 2 ")//第二秒
                     .append(" -t 00:00:00.001 ")//持续时间
                     .append(" -s 480x480 ")//图片尺寸
                     .append(outFile);//输出图片文件
        String command = stringBuilder.toString();
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(command);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);//ffmpeg程序执行过程的输出
            }
        } catch (Throwable t) {
            t.printStackTrace();
            return false;
        }
        return true;
    }

    //删除文件和目录
    private static void clearFiles(String workspaceRootPath) {
        File file = new File(workspaceRootPath);
        if (file.exists()) {
            deleteFile(file);
        }
    }
    private static void deleteFile(File file) {
        if (file.isDirectory()) {//递归调用
            File[] files = file.listFiles();
            if(files != null){
                for (File f : files) {
                    deleteFile(f);
                }
            }
        }
        file.delete();
    }
}
