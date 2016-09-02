package shine.st.common.aws


import java.io.{ByteArrayInputStream, File}

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.ObjectMetadata


/**
  * Created by stevenfanchiang on 2016/3/24.
  */
object S3 {
  val s3Client = new AmazonS3Client()

  def getObject(bucketName: String, objectName: String) = {
    s3Client.getObject(bucketName, objectName)
  }

  def getObjectContent(bucketName: String, objectName: String) = {
    getObject(bucketName, objectName).getObjectContent
  }

  def putObject(bucketName: String, file: File) = {
    s3Client.putObject(bucketName, file.getName, file)
  }

  def putObject(bucketName: String, fileName: String, content: String) = {
    val bytes = content.getBytes("UTF-8")
    val metaObject = new ObjectMetadata()
    metaObject.setContentLength(content.getBytes.length)

    //    String to inputstream
    s3Client.putObject(bucketName, fileName, new ByteArrayInputStream(bytes), metaObject)

  }
}
