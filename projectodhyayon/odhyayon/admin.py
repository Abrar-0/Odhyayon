from django.contrib import admin
from .models import Teacher,Student,Courses, user, upload

admin.site.register(Teacher)
admin.site.register(Student)
admin.site.register(Courses)
admin.site.register(upload)
admin.site.register(user)
