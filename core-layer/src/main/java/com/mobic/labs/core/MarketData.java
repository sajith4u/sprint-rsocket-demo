package com.mobic.labs.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SAJITH
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketData {
    private int id;
    private String unit;
    private String value;
}
