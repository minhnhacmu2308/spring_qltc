package com.qltc.springqltc.utils;

import com.qltc.springqltc.constants.MyConstants;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class UploadFile {
    public String upload(HttpServletRequest request,MultipartFile image){
        if(image.isEmpty()) {
            System.out.println("Rỗng");

        }
        String dirname = request.getServletContext().getRealPath(MyConstants.PATH_UPLOAD);

        Path path = Paths.get(dirname);
        try {
            InputStream inputStream = image.getInputStream();

            String name = String.valueOf(new Date().getTime()+image.getOriginalFilename().toLowerCase());
            Files.copy(inputStream, path.resolve(name), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(name);
            return name;

        } catch (Exception e) {
            // TODO: handle exceptione.p
            e.printStackTrace();
            return null;
        }

    }
}
