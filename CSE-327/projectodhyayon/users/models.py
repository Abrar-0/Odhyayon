from django.db import models

from django.db import models
from django.contrib.auth.models import User
import os
from django.db.models.fields.related import OneToOneField
from django.urls import reverse

def path_and_rename(instance, filename):
    upload_to = 'Images/'
    ext = filename.split('.')[-1]
    # get filename
    if instance.pk:
        filename = 'User_Profile_Pictures/{}.{}'.format(instance.pk, ext)
    return os.path.join(upload_to, filename)

class UserProfileInfo(models.Model):

    #creating a relationship with user class (not inheriting)
    user = models.OneToOneField(User,related_name='profile',on_delete=models.CASCADE)
    #profile_pic = models.ImageField(upload_to=path_and_rename, verbose_name="Profile Picture", blank=True)
    teacher = 'teacher'
    student = 'student'
    
    user_types = [
        (teacher, 'teacher'),
        (student, 'student')
    ]
    user_type = models.CharField(max_length=10, choices=user_types, default=student,name="user_type")

    def __str__(self):
        return self.user.username
