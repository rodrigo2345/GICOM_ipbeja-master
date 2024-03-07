package com.example.gicom_ipbeja.data.localdatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface CourseService {

    @GET("courses")
    Call<List<CoursesItem>> getCourses();

    @DELETE("courses")
    Call<List<CoursesItem>> deleteCourses();

    @POST("courses")
    Call<List<CoursesItem>> addCourses();

    @PUT("courses")
    Call<List<CoursesItem>> updateCourses();


}