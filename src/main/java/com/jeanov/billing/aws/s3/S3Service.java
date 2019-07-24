package com.jeanov.billing.aws.s3;

import java.io.File;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.jeanov.billing.aws.AWSConfig;

public class S3Service {

	private AmazonS3 s3Client;

	public S3Service() {
		this.s3Client = this.generateS3Client();
	}

	public AmazonS3 generateS3Client() {
		return AmazonS3ClientBuilder.standard().withCredentials(AWSConfig.CREDENTIALS_PROVIDER)
				.withRegion(Regions.US_EAST_2).build();
	}

	public void createBucket(String bucketName) {
		if (this.s3Client.doesBucketExistV2(bucketName)) {
			System.out.println(bucketName + " already exists!");
			return;
		}
		this.s3Client.createBucket(bucketName);
	}
	
	public void saveObject() {
		PutObjectRequest putObjectRequest = new PutObjectRequest("<BUCKET_NAME>", "<PATH>", new File("<FILE_PATH>"));
		this.s3Client.putObject(putObjectRequest );
		
	}
	
	public static void main(String[] args) {
		S3Service s3 = new S3Service();
		s3.saveObject();
	}
}
