/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT4;

/**
 *
 * @author dattk
 */
public class Process {
    private int proId;
    private int arrTime;
    private int burTime;
    
    public Process() {
    }

    public Process(int proId, int arrTime, int burTime) {
        this.proId = proId;
        this.arrTime = arrTime;
        this.burTime = burTime;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int getArrTime() {
        return arrTime;
    }

    public void setArrTime(int arrTime) {
        this.arrTime = arrTime;
    }

    public int getBurTime() {
        return burTime;
    }

    public void setBurTime(int burTime) {
        this.burTime = burTime;
    }
    
    @Override
    public String toString(){
        return proId + "\t" + arrTime + "\t" + burTime; 
    }
}
