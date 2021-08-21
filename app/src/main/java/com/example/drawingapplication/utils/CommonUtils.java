package com.example.drawingapplication.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.drawingapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {

    public static String phoneNumberErrorMessage = null;
    public static String passwordErrorMessage = null;

    /**
     * Internet connectivity checker
     */
    public static boolean isConnectedToInternet() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Internet connectivity checker with context
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {

        if (phoneNumber.isEmpty()) {
            phoneNumberErrorMessage = "Phone number can't be empty.";
            return false;
        }

        if (phoneNumber.length() != 11) {
            phoneNumberErrorMessage = "Phone number length should be 11";
            return false;
        }

        if (!android.util.Patterns.PHONE.matcher(phoneNumber).matches()) {
            phoneNumberErrorMessage = "Invalid phone number";
            return false;
        }

        phoneNumberErrorMessage = null;
        return true;
    }

    public static boolean validatePassword(String password) {
        if (password.isEmpty()) {
            passwordErrorMessage = "Password can't be empty.";
            return false;
        }

        if (password.length() < 6) {
            passwordErrorMessage = "Password length should be at least 6";
            return false;
        }

        passwordErrorMessage = null;
        return true;
    }

    /**
     * convert string to date format "yyyy-MM-dd"
     */
    @SuppressLint("SimpleDateFormat")
    public static Date stringToDate(String inputDate) {
        Date date = null;
        try {
            DateFormat stringDate = new SimpleDateFormat("yyyy-MM-dd");
            date = stringDate.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * convert string to date format "yyyy-MM-dd"
     */
    @SuppressLint("SimpleDateFormat")
    public static boolean compareTwoDates(String selectedDate, String creationDate) {

        Log.e("Selected Date", selectedDate);
        Log.e("Creation Date", creationDate);

        Date date1 = stringToDate(selectedDate);
        Date date2 = stringToDate(creationDate);

        if (date1.equals(date2) || date1.after(date2)) {
            Log.e("Date comparison", selectedDate + " is after or equals to " + creationDate);
            return true;
        } else {
            Log.e("Date comparison", selectedDate + " is before " + creationDate);
            return false;
        }

    }

    /**
     * convert date format from "dd MMM yyyy" to "yyyy-MM-dd"
     */
    @SuppressLint("SimpleDateFormat")
    public static String convertDate(String inputDate) {
        try {
            DateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy");
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(inputDate);
            assert date != null;
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return inputDate;
    }

    /**
     * convert date format from "yyyy-MM-dd" to "dd MMM yyyy"
     */
    @SuppressLint("SimpleDateFormat")
    public static String convertDate2(String inputDate) {
        try {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
            Date date = inputFormat.parse(inputDate);
            assert date != null;
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return inputDate;
    }

    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDate() {

        final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

        DateFormat df = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
        return df.format(Calendar.getInstance().getTime());
    }

    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDateTimeString() {

        final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        DateFormat df = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
        return df.format(Calendar.getInstance().getTime());
    }

    public static String getLocaleDate(Date dateString) {
        try {
            Date currentDate = new Date(String.valueOf(dateString));
            @SuppressLint("SimpleDateFormat")
            DateFormat df = new SimpleDateFormat("dd MMM yyyy");

            //formatted value of current Date

            return df.format(currentDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(dateString);
    }

    /**
     * Read JSON file
     */
    public static String loadJsonFile(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
