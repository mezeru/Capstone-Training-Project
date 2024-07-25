package com.microservice.account.dto;
import java.time.LocalDateTime;

public class PointsHistoryDto {
    private String itemName;
    private String managerName;
    private int points;
    private LocalDateTime timestamp;

    // Constructors, getters, setters, and adjustPoints method
    public PointsHistoryDto() {}

    public PointsHistoryDto(String itemName, String managerName, int points, LocalDateTime timestamp) {
        this.itemName = itemName;
        this.managerName = managerName;
        this.points = points;
        this.timestamp = timestamp;
        adjustPoints(); // Adjust points when creating the object
    }

    // Getters and setters
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; adjustPoints(); }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; adjustPoints(); }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    // Adjust points if itemName is present
    private void adjustPoints() {
        if (this.itemName != null && !this.itemName.isEmpty()) {
            this.points = -this.points;
        }
    }
    
}
