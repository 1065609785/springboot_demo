package com.demo.demo_rpc_service.fastdfs;

import com.demo.bean.DemoResult;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * @program: springboot_demo
 * @description: fastDfs工具类
 * @author: zhaoshouyun
 * @create: 2020-01-17 17:44
 **/
@Component
@Slf4j
public class FastDfsClientUtil {

    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * @Author zhaoshouyun
     * @Description MultipartFile类型的文件上传ַ
     * @Date 2020/01/19
     * @Param [file]
     * @return com.hiynn.data.visual.file.vo.ResultData<java.lang.String>
     */
    public DemoResult<String> uploadFile(MultipartFile file){

        try{
            StorePath path = storageClient.uploadFile(file.getInputStream(), file.getSize(),
                    FilenameUtils.getExtension(file.getOriginalFilename()), null);
            return DemoResult.SUCCESS(path.getFullPath());
        }catch (Exception e){
            e.printStackTrace();
            return DemoResult.FAIL();
        }

    }
    /**
     * @Author zhaoshouyun
     * @Description 普通的文件上传
     * @Date 2020/01/19
     * @Param [file]
     * @return com.hiynn.data.visual.file.vo.ResultData<java.lang.String>
     */
    public DemoResult<String> uploadFile(File file){

        try{
            FileInputStream inputStream = new FileInputStream(file);
            StorePath path = storageClient.uploadFile(inputStream, file.length(),
                    FilenameUtils.getExtension(file.getName()), null);
            return DemoResult.SUCCESS(path.getFullPath());
        }catch (Exception e){
            e.printStackTrace();
            return DemoResult.FAIL();
        }
    }

    /**
     * @Author zhaoshouyun
     * @Description 带输入流形式的文件上传
     * @Date 2020/01/19
     * @Param [is, size, fileName]
     * @return com.hiynn.data.visual.file.vo.ResultData<java.lang.String>
     */
    public DemoResult<String> uploadFileStream(InputStream is, long size, String fileName) {
        StorePath path = storageClient.uploadFile(is, size, fileName, null);
        return DemoResult.SUCCESS(path.getFullPath());
    }

    /**
     * @Author zhaoshouyun
     * @Description 将一段文本文件写到fastdfs的服务器上
     * @Date 2020/01/19
     * @Param [content, fileExtension]
     * @return java.lang.String
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath path = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        return path.getFullPath();
    }

    /**
     * @Author zhaoshouyun
     * @Description 删除文件
     * @Date 2020/01/19
     * @Param [fileUrl]
     * @return com.hiynn.data.visual.file.vo.ResultData
     */
    public DemoResult deleteFile(String fileUrl) {

        if (StringUtils.isEmpty(fileUrl)) {
            return DemoResult.FAIL();
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
            return DemoResult.SUCCESS();
        } catch (FdfsUnsupportStorePathException e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            return DemoResult.FAIL();
        }
    }

      /**
       * @Author zhaoshouyun
       * @Description 上传文件图片
       * @Date 2020/01/19
       * @Param [is, size, fileExtName, metaData]
       * @return java.lang.String
       */
      public String upfileImage(InputStream is, long size, String fileExtName, Set<MetaData> metaData) {
        StorePath path = storageClient.uploadImageAndCrtThumbImage(is, size, fileExtName, metaData);
        return path.getFullPath();
      }
}
