package com.ride.enums;

public enum RideStatus {
	PendingBooking,      
    DriverEnRoute,      // Driver is on the way to the pickup location
    ArrivedAtPickup,    // Driver has arrived at the pickup location
    RideStarted,        // Ride is currently in progress
    RideInTransit,      // Ride is underway to the destination
    WaitingAtStop,      // Ride is paused (e.g., for a stopover)
    RideCompleted,      // Ride has successfully concluded
    CanceledByUser,     // Ride canceled by the user
    CanceledByDriver,   // Ride canceled by the driver
    NoShow,             // Driver or passenger did not show up
  
	Delayed, // Driver arrival or ride is delayed

}
