package com.example.w9001134.rrrrrrrrrr;

/**
 * Time:2019/10/24
 * Author:zhw
 * Description:
 */

import com.example.lintaar.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * 文件工具类。
 *
 * @author <a href="http://www.xfyun.cn">讯飞开放平台</a>
 * @date 2016年7月23日 上午10:31:30
 */
public class FileUtil {

    public final static String SURFFIX_PCM = ".pcm";

    public final static String SURFFIX_TXT = ".txt";

    public final static String SURFFIX_CFG = ".cfg";
    private boolean flag;

    /**
     * 数据文件类，用于读写文件。
     *
     * @author hj
     * @date 2016年5月11日 下午2:18:47
     */
    public static void write(String path) {
        File file = new File(path);
        BufferedWriter bw;

        {
            try {
                bw = new BufferedWriter(new FileWriter(file));
                //一次性写入json或者String
                bw.write("中转站重中之重中转站重中之重");//换行
                bw.flush();
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
