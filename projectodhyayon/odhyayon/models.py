from django.db import models
from django.http import HttpResponseRedirect
from django.shortcuts import render
from django.contrib.auth.models import User
from django.urls import reverse
from django.contrib.auth.models import AbstractUser

class user(AbstractUser):
    is_admin = models.BooleanField('Is admin', default=False)
    is_student = models.BooleanField('Is student', default = False)
    is_teacher = models.BooleanField('Is teacher', default = False)

class Courses(models.Model):
    title=models.CharField(max_length=255)
    objects=models.Manager()
    
    def get_absolute_url(self):
     return reverse('dashboard')
     
    def __str__(self) :
        return (self.title)
   
class Teacher(models.Model):
    First_name = models.TextField(null=False)
    Last_name = models.TextField(null=True)
    Phone_number=models.TextField(null=True)
    Date_of_birth=models.DateField()
    email = models.CharField(max_length=300)
    password = models.TextField()
    course_id=models.ForeignKey(Courses,on_delete=models.DO_NOTHING)
    objects=models.Manager()

class Student(models.Model):
    First_name = models.TextField(null=False)
    Last_name = models.TextField(null=True)
    profile_pic=models.FileField()
    Phone_number=models.TextField(null=True)
    Date_of_birth=models.DateField()
    email = models.CharField(max_length=300)
    password = models.TextField()
    objects = models.Manager()


class upload(models.Model):
    course_id=models.ForeignKey(Courses,on_delete=models.DO_NOTHING,null=True)
    title=models.CharField(max_length=50)
    pdf=models.FileField(upload_to="media")
    uploaded_at = models.DateTimeField(auto_now_add=True, null=True)

    def get_absolute_url(self):
        return reverse('dashboard')