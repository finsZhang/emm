package com.ai.emm.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by Walter on 2016/8/23.
 */
public class UpFileUtils {
    /**
     *
     * 功能描述：保存图片
     * @author fanlx
     * Jan 6, 2015  7:38:32 PM
     * @param
     * @return
     */
    public static void uploadPic(MultipartFile file, String realPath, String newFileName)  throws Exception{
        File targetFile = new File(realPath,newFileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
    }

}
