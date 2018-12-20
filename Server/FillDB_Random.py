import sqlite3,os,random

#Get the directory of the current file and connect to the database in it
dirPath = os.path.abspath(os.path.dirname(__file__))
dbPath = os.path.join(dirPath, 'Database/halls.db')
connection = sqlite3.connect(dbPath)

c = connection.cursor()

days = ['Saturday','Sunday','Monday','Tuesday','Wednesday','Thursday']
slots = [1,2,3,4,5,6,7,8,9,10,11,12]
halls = ['901','901A','902','902A','902B',
        '904','911','911A','912','913','914','914A',
        '921','922','923','921A','924','924A',
        '931','931A','932','933',
        '941','941A','942','943','944','944A']
course_num = ['CSE115','CSE125','CSE116','CSE126','CSE127','CSE128','CSE221','CSE222','CSE223','CSE275','CSE227','CSE224','CSE225','CSE226','CSE215','CSE365','CSE335','CSE325','CSE316','CSE336','CSE326','CSE345','CSE415','CSE436','CSE425','CSE437','CSE426','CSE427']
instructors = ['instructorA','instructorB','instructorC','instructorD','instructorE','instructorF','instructorG','instructorH','instructorI',]


courses_dict = {
    "CSE 115" : "Digital Design", 
    "CSE 116" : "Computer Architecture", 
    "CSE 125" : "Computer Programming (1)", 
    "CSE 126" : "Computer Programming (2)", 
    "CSE 127" : "Data Structures and Algorithms", 
    "CSE 128" : "Software Engineering (1)", 
    "ECE 141" : "Electrical and Electronic Circuits", 
    "CSE 215" : "Electronic Design Automation", 
    "CSE 221" : "Object-Oriented Analysis and Design", 
    "CSE 222" : "Software Engineering (2)", 
    "CSE 223" : "Operating Systems", 
    "CSE 224" : "Design and Analysis of Algorithms", 
    "CSE 225" : "Software Testing, Validation, and Verification", 
    "CSE 226" : "Design of Compilers", 
    "CSE 227" : "Database Systems (1)", 
    "ECE 255" : "Signals and Systems", 
    "CSE 275" : "Control Engineering", 
    "CSE 316" : "Microcontrollers and Interfacing", 
    "CSE 325" : "Agile Software Engineering", 
    "CSE 326" : "Software Formal Specifications", 
    "CSE 335" : "Computer Networks", 
    "CSE 336" : "Distributed Computing", 
    "CSE 345" : "Real-Time and Embedded Systems Design", 
    "CSE 365" : "Computer Vision", 
    "CSE 415" : "High-Performance Computing", 
    "CSE 425" : "Software Design Patterns", 
    "CSE 426" : "Software Maintenance and Evolution", 
    "CSE 427" : "Software Project Management", 
    "CSE 436" : "Computer and Network Security", 
    "CSE 437" : "Mobile Computing", 
    "CSE 496" : "Graduation Project (1)", 
    "CSE 497" : "Graduation Project (2)" 
}


for course in course_num:
     c.execute('''INSERT INTO courseIns (course_num,instructor_name) VALUES (?,?)'''
     ,(random.choice(course_num),random.choice(instructors)))

for day in days:
    for slot in slots:
        for hall in halls:
            if(random.randint(0,10)==7):
                continue
            c.execute('''INSERT INTO schedule VALUES (?,?,?,?)''',
            (day,
            slot,
            hall,
            random.randint(1,29))
            )

connection.commit()
connection.close()
        