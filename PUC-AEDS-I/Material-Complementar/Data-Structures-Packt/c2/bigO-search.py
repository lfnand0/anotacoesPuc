student_list1 = ['tim', 'drake', 'ashish', 'shubham']
student_list2 = ['andrew', 'chris', 'harshit', 'lary', 'shubham']

def checkStudent(studentList):
  for student in studentList:
    if student == 'shubham':
      print('Available')

checkStudent(student_list1)