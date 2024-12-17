package com.ride.enums;

public enum PaymentStatus {
	PENDING,        // Payment is yet to be initiated
    COMPLETED,      // Payment has been successfully completed
    FAILED,         // Payment failed due to some issue
    CANCELLED,      // Payment was cancelled by the user
    REFUNDED,       // Payment was refunded to the user
    PARTIALLY_PAID, // Payment was made partially, with balance pending
    IN_PROGRESS,    // Payment is currently being processed
}
