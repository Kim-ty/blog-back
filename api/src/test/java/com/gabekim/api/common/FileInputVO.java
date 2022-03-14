package com.gabekim.api.common;

import lombok.Getter;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Getter
public class FileInputVO {
    private String paramKey = null;
    private MockMultipartFile mockMultipartFile = null;

    public FileInputVO(String paramKey, String filePath) throws IOException {

        File file = new File(filePath);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        this.paramKey = paramKey;
        this.mockMultipartFile = new MockMultipartFile(this.paramKey,file.getName(),null,fileContent);
    }

}
