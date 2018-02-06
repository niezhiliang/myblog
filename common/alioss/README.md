# alioss
oss通用类   上传 下载 删除
### oss通用util
>> 使用只需要在该模块拉倒你的项目中 
>>> 然后在项目中把oss依赖加进去，最后把该模块下的application.yml中的配置参数复制到你项目的application.yml中就可以用啦
>>>> 应该满足一般的上传流 byte[] 本地file 

### BufferdImage 转 InputeStream
    URL url = new URL("http://www.google.com/intl/en_ALL/images/logo.gif");   
    BufferedImage image = ImageIO.read(url);  
    ByteArrayOutputStream os = new ByteArrayOutputStream();  
    ImageIO.write(image, "gif", os);  
    InputStream is = new ByteArrayInputStream(os.toByteArray()); 
### 如果在上传base64到oss 得到的是一张透明的图片可能是因为url没有进行转码
    base64.replace(' ','+');
