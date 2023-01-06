from django.db import models
from django.http import HttpResponseRedirect
from django.shortcuts import render
from django.contrib.auth.models import User
from django.urls import reverse
# Create your models here.
class Teacher(models.Model):
    ID=models.AutoField(primary_key=True)
    First_name = models.TextField(null=False)
    Last_name = models.TextField(null=True)
    Phone_number=models.TextField(null=True)
    Date_of_birth=models.DateField()
    Email = models.CharField(max_length=300)
    Password = models.TextField()