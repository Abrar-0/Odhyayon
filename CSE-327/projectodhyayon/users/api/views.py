from django.contrib.auth.models import User
import rest_framework
from rest_framework import serializers, status
from rest_framework.response import Response
from rest_framework.decorators import api_view
from users.models import UserProfileInfo
from users.api.serializers import StudentSerializer, UserSerializer
from rest_framework.decorators import api_view, permission_classes
from rest_framework import permissions
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status

@permission_classes((permissions.AllowAny,))
class StudentRecordView(APIView):
   
    def get(self, format=None):
      
        students = User.objects.all()
        serializer = UserSerializer(students, many=True)
        return Response(serializer.data)

    def post(self, request, format = None):
      

        #serializer = UserSerializer(data=request.data)
        #if serializer.is_valid(raise_exception=ValueError):
            #serializer.create(validated_data=request.data)
        
        serializer = UserSerializer(data=request.data)
        if serializer.is_valid(raise_exception=ValueError):
            serializer.create(validated_data=request.data)
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.error_messages,
                        status=status.HTTP_400_BAD_REQUEST)
