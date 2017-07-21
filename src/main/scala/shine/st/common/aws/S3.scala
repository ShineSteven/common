package shine.st.common.aws


import java.io.{ByteArrayInputStream, File, InputStream}

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.{ObjectMetadata, S3Object}


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

  def copyObject(bucketName: String, objectName: String, newObjectName: String) = {
    val s3Object = getObject(bucketName, objectName)
    s3Client.putObject(bucketName, newObjectName, s3Object.getObjectContent, s3Object.getObjectMetadata)
  }

  def putObject(bucketName: String, file: File) = {
    s3Client.putObject(bucketName, file.getName, file)
  }

  def putObject(bucketName: String, objectName: String, content: String) = {
    val bytes = content.getBytes("UTF-8")
    val metaObject = new ObjectMetadata()
    metaObject.setContentLength(content.getBytes.length)

    //    String to input stream
    s3Client.putObject(bucketName, objectName, new ByteArrayInputStream(bytes), metaObject)
  }

  def deleteObject(bucketName: String, objectName: String) = {
    s3Client.deleteObject(bucketName, objectName)
  }
}
