import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Paper } from '@mui/material';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import { useEffect } from 'react';
export default function Student() {
  const paperStyle = {padding: '30px 30px', width:600, margin: "30px auto"}
  const[name,setName] = useState('')
  const[address,setAddress] = useState('')
  const[students, setStudents]=useState([])

  const handleClick=(e)=>{
    e.preventDefault()
    const student = {name, address}
    console.log(student)
    fetch("http://localhost:8080/student/add", {
        method: 'POST',
        headers:{"Content-Type": "application/json"},
        body: JSON.stringify(student)
    }).then(()=>{
            console.log("New Student Added.")
        })
  }

  useEffect(()=>{
    fetch("http://localhost:8080/student/getall")
    .then(res=>res.json())
    .then((result)=>{
        setStudents(result);
    })
  },[])

  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}>Add Student</h1>
        <Box
        component="form"
        sx={{
         '& > :not(style)': { m: 1, width: '25ch' },
        }}
        noValidate
        autoComplete="off"
        >
        <TextField id="sname" label="Student Name" variant="outlined" fullWidth value={name} onChange={(e)=>setName(e.target.value)}/>
        <TextField id="saddress" label="Address" variant="outlined" fullWidth value={address} onChange={(e)=>setAddress(e.target.value)}/>
        <Button variant="outlined" onClick={handleClick}>Submit</Button>
        </Box>
        </Paper>
        <Paper elevation={3} style={paperStyle}>
            
            {students.map(student=>(
                <Paper elevation={6} style={{margin:"10px", padding:"15px", textAlign:"left"}} key={student.id}>
                    Id : {student.id} <br />
                    Name : {student.name} <br />
                    Address : {student.address}                   
                </Paper>
            ))}
        </Paper>
    </Container>
  );
}
