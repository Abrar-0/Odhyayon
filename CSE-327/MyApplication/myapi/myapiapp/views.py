from django.shortcuts import render

# Create your views here.
from django.views.decorators.csrf import csrf_exempt
from rest_framework.parsers import JSONParser
from django.http.response import JsonResponse
from rest_framework import viewsets
from django.shortcuts import get_object_or_404

from myapiapp.models import Teacher
from myapiapp.serializers import TeacherSerializer

from django.core.files.storage import default_storage

# Create your views here.
class PersonViewset(viewsets.ViewSet):
    queryset = Teacher.objects.all().order_by('ID')
    serializer_class = TeacherSerializer
@csrf_exempt
def teacherApi(request,id=0):
    if request.method=='GET':
        teacher = Teacher.objects.all()
        teacher_serializer=TeacherSerializer(teacher,many=True)
        return JsonResponse(teacher_serializer.data,safe=False)
    elif request.method=='POST':
        teacher_data=JSONParser().parse(request)
        teacher_serializer=TeacherSerializer(data=teacher_data)
        if teacher_serializer.is_valid():
            teacher_serializer.save()
            return JsonResponse("Added Successfully",safe=False)
        return JsonResponse("Failed to Add",safe=False)
    elif request.method=='PUT':
        teacher_data=JSONParser().parse(request)
        teacher=Teacher.objects.get(ID=['id'])
        teacher_serializer=TeacherSerializer(teacher,data=teacher_data)
        if teacher_serializer.is_valid():
            teacher_serializer.save()
            return JsonResponse("Updated Successfully",safe=False)
        return JsonResponse("Failed to Update")
    elif request.method=='DELETE':
        teacher=Teacher.objects.get(ID=id)
        Teacher.delete()
        return JsonResponse("Deleted Successfully",safe=False)