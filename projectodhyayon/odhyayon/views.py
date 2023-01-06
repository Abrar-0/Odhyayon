from django.http.response import Http404
from django.shortcuts import render, redirect
from django.http import HttpResponse,JsonResponse
from django.http import HttpResponseRedirect
from django.shortcuts import render
from django.contrib.auth.models import User,auth
from .models import Student, Teacher, upload, Courses, user
from django.views.generic.edit import CreateView,UpdateView,DeleteView,FormView
from django.urls import reverse_lazy
from django.http import Http404
from django.views import generic
from django.contrib.auth.forms import UserCreationForm
from random import randint
from .forms import SignUpForm, LoginForm
from django.contrib.auth import authenticate, login
from django import forms

# Create your views here.

def homepage(request):
    return render(request,'odhyayon/index.html')

def loginproceed(request):
    return render(request,'odhyayon/LoginProceed.html')

def studentlogin(request):
    return render(request,'odhyayon/studentLogin.html')

#def teacherlogin(request):
    #return render(request,'odhyayon/teacherLogin.html')

def signupproceed(request):
    return render(request,'odhyayon/SignupProceed.html')

def studentsignup(request):
    return render(request,'odhyayon/studentSignup.html')

def teachersignup(request):
    return render(request,'odhyayon/teacherSignup.html')

class DashboardView(generic.ListView):
     template_name = 'odhyayon/dashboard.html'
     context_object_name = 'object_list'
     def get_queryset(self):
         return Courses.objects.all()

class DetailView(generic.DetailView):
        model = Courses
        context_object_name = 'course'
        template_name = 'upload.html'

   
def  formsubmitted(request):
    mydictionary = {
       
       "var1" : request.POST['studentemail'],
       "var2" : request.POST['studentpass'],
       "method" : request.method
    }

    return JsonResponse(mydictionary)


class StudentCreate(CreateView):
    model = Student
    fields = '__all__'
    template_name = 'odhyayon/studentSignup.html'
    success_url = reverse_lazy('index')

class ClassCreate(CreateView):
    model = Courses
    fields = ['title']

class uploadCreate(CreateView):
    model = upload
    fields = '__all__'

class uploadDelete(DeleteView):
    model = upload
    success_url = reverse_lazy('dashboard')

class ClassUpdate(UpdateView):
    model = Courses
    fields = ['pdf']

class ClassDelete(DeleteView):
    model = Courses
    success_url = reverse_lazy('dashboard')

class TeacherCreate(CreateView):
    model = Teacher
    fields = '__all__'
    template_name = 'odhyayon/teacherSignup.html'
    success_url = reverse_lazy('dashboard')

class StudentUpdate(UpdateView):
    model = Student
    fields = ['First_name','Last_name','Phone_number','Email','Password','profile_pic']
    success_url = reverse_lazy('index')
    template_name = 'odhyayon/studentSignup.html'

class TeacherUpdate(UpdateView):
    model = Teacher
    fields = ['First_name','Last_name','Phone_number','Email','Password','profile_pic']
    success_url = reverse_lazy('index')
    template_name = 'odhyayon/teacherSignup.html'

class StudentDelete(DeleteView):
    model = Student
    template_name = 'odhyayon/'
    context_object_name = 'studel'
    success_url = reverse_lazy('index')

class TeacherDelete(DeleteView):
    model = Teacher
    template_name = 'odhyayon/'
    context_object_name = 'teadel'
    success_url = reverse_lazy('index')

