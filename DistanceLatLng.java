//Copied from https://dzone.com/articles/distance-calculation-using-3

public class DistanceLatLngs {
    public static void main(String args[]) {
        int x = 10;
        int y = 25;
        int z = x + y;
        // prints the distance in Meters - 33.33650445564029
        System.out.println(distance(11.336777, 75.928332, 11.336866, 75.928040, 'I'));
        
        // prints the distance in Kilometers - 0.033336504455640285
        System.out.println(distance(11.336777, 75.928332, 11.336866, 75.928040, 'K'));
        
        // prints the distance in Miles - 0.0207143435186264
        System.out.println(distance(11.336777, 75.928332, 11.336866, 75.928040, 'M'));
        
        // prints the distance in Nautical Miles - 0.017988335911575164
        System.out.println(distance(11.336777, 75.928332, 11.336866, 75.928040, 'N'));
    }


    private static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515; //miles
        if (unit == 'K') {
            dist = dist * 1.609344; //Kilometers
        } else if (unit == 'N') {
            dist = dist * 0.8684; // Nautical Miles
        } else if (unit == 'I') {
            dist = dist * 1.609344 * 1000; //Meters
        }
        return (dist);
    }
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
