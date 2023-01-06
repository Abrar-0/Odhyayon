from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
from users.models import UserProfileInfo
from django.contrib.auth.models import AbstractUser

class UserForm(UserCreationForm):
    email = forms.EmailField()


    class Meta():
        model = User
        fields = ('username','first_name','last_name', 'email', 'password')

        # widgets = {
        # "password":"forms.PasswordInput()",
        # }

        labels = {
        'password1':'Password',
        'password2':'Confirm Password'
        }

class UserProfileInfoForm(forms.ModelForm):

   
    teacher = 'teacher'
    student = 'student'
    user_types = [
        (student, 'student'),
        (teacher, 'teacher')
    ]
    
    user_type = forms.ChoiceField(required=True, choices=user_types)

    class Meta():
        model = UserProfileInfo
        fields = ('user_type')