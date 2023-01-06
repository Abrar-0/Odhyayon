# Generated by Django 3.1.3 on 2021-08-24 20:31

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Teacher',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('First_name', models.TextField()),
                ('Last_name', models.TextField(null=True)),
                ('Phone_number', models.TextField(null=True)),
                ('Date_of_birth', models.DateField()),
                ('Email', models.CharField(max_length=300)),
                ('Password', models.TextField()),
            ],
        ),
    ]