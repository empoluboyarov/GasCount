package com.example.evgeniy.gascount;

/**
 * Created by Evgeniy on 01.03.2016.
 */
public class Count {

    private double density;
    private double temp;
    private double pressure;
    private double nitrogen;

    private double relativeDensity;
    private double koefAdiabati;
    private double z;

    public Count(double density) {
        this.density = density;
    }

    public Count(double density, double temp, double pressure) {
        this.density = density;
        this.temp = temp;
        this.pressure = pressure;
    }

    public Count(double density, double temp, double pressure, double nitrogen) {
        this.density = density;
        this.temp = temp;
        this.pressure = pressure;
        this.nitrogen = nitrogen;
    }

    public double getRelativeDensity() {
        relativeDensity = density/1.2044;
        return relativeDensity;
    }

    public double getKoefAdiabati() {
        return koefAdiabati;

    }

    public double getZ() {
        z = 1-((10.2*(pressure*0.09806649999787736)- 6)*(0.00345*(getRelativeDensity())-0.000446)+0.015)*(1.3-0.0144*(temp+273.15-283.2));
        return z;
    }
}
