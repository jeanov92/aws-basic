package com.jeanov.billing.aws.sqs;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.jeanov.billing.aws.AWSConfig;

public class SQSService {

	private final String QUEUE_URL = "<SQS URL>";

	private AmazonSQS sqsClient = AmazonSQSClientBuilder.standard().withCredentials(AWSConfig.CREDENTIALS_PROVIDER)
			.withRegion(AWSConfig.REGIONS).build();

	public void sendMessage() {

		Map<String, MessageAttributeValue> message = new HashMap<>();
		message.put("FirstAttribute",
				new MessageAttributeValue().withDataType("String").withStringValue("Some Attributte"));

		SendMessageRequest messageRequest = new SendMessageRequest().withQueueUrl(QUEUE_URL)
				.withMessageBody("Hello from Java").withMessageAttributes(message).withDelaySeconds(50);
		sqsClient.sendMessage(messageRequest);
	}

	public void receiveMessage() {
		ReceiveMessageRequest messageRequest = new ReceiveMessageRequest().withQueueUrl(QUEUE_URL)
				.withWaitTimeSeconds(20);
		sqsClient.receiveMessage(messageRequest);
	}
}
