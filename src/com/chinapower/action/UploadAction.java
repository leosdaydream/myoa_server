package com.chinapower.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.chinapower.org.action.BasicAction;

public class UploadAction extends BasicAction {
	private static final long serialVersionUID = -733866696189281750L;
	
    //�ϴ��ļ�����   
    private List<File> file;   
    //�ϴ��ļ�������   
    private List<String> fileFileName;   
    //�ϴ��ļ��������ͼ���   
    private List<String> fileContentType;   
    private String savePath;
    
    public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public List<File> getFile() {   
        return file;   
    }   

    public void setFile(List<File> file) {   
        this.file = file;   
    }   

   public List<String> getFileFileName() {   
       return fileFileName;   
   }   

    public void setFileFileName(List<String> fileFileName) {   
        this.fileFileName = fileFileName;   
    }   

    public List<String> getFileContentType() {   
        return fileContentType;   
    }   

    public void setFileContentType(List<String> fileContentType) {   
        this.fileContentType = fileContentType;   
    }   

    public String uploadfile() throws Exception {   
        System.out.println(this.getFileFileName());  
        for (int i = 0; i < file.size(); i++) {   
            //ѭ���ϴ�ÿ���ļ�   
            submit(i);   
        }   
        return "success";   
    }   

    //ִ���ϴ�����   
    private void submit(int i) throws Exception {   
        try {   
            InputStream in = new FileInputStream(file.get(i));   
//            String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);  
            String dstPath = ServletActionContext.getServletContext().getRealPath(
    				this.getSavePath());
            System.out.println(dstPath);
            File fileLocation = new File(dstPath);  
            //�˴�Ҳ������Ӧ�ø�Ŀ¼�ֶ�����Ŀ���ϴ�Ŀ¼  
            if(!fileLocation.exists()){  
                boolean isCreated  = fileLocation.mkdir();  
                if(!isCreated) {  
                    //Ŀ���ϴ�Ŀ¼����ʧ��,������������,�����׳��Զ����쳣��,һ��Ӧ�ò���������������  
                    return;  
                }  
            }  
            String fileName=this.getFileFileName().get(i);  
            File uploadFile = new File(dstPath, fileName);   
            OutputStream out = new FileOutputStream(uploadFile);   
            byte[] buffer = new byte[1024 * 1024];   
            int length;   
            while ((length = in.read(buffer)) > 0) {   
                out.write(buffer, 0, length);   
            }   
            in.close();   
            out.close();   
        } catch (FileNotFoundException ex) {   
            System.out.println("�ϴ�ʧ��!");  
            ex.printStackTrace();   
        } catch (IOException ex) {   
            System.out.println("�ϴ�ʧ��!");  
            ex.printStackTrace();   
        }   
    }   
}

