package test;import com.aliyun.oss.OSS;import com.aliyun.oss.OSSClientBuilder;/** * @Author xiaoYan * @Data 2022/12/21 16:12 * 时间不早了  注意休息 */public class Demo {    public static void main(String[] args) throws Exception {        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。        String endpoint = "https://oss-cn-beijing.aliyuncs.com";        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。        String accessKeyId = "LTAI5tQKPaBtNB6bUBhbpb7i";        String accessKeySecret = "S7n3nBzfdh8p7ia78BIBMNd3YielaH";        // 填写Bucket名称，例如examplebucket。        String bucketName = "yygh-xja-xy";        // 创建OSSClient实例。        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);            // 创建存储空间。        ossClient.createBucket(bucketName);        ossClient.shutdown();        }}