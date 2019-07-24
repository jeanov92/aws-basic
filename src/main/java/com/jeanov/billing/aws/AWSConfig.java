package com.jeanov.billing.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;

public class AWSConfig {
	public static final AWSCredentialsProvider CREDENTIALS_PROVIDER = new AWSStaticCredentialsProvider(
			new ProfileCredentialsProvider("default").getCredentials());
	public static final Regions REGIONS = Regions.US_EAST_2;
}
