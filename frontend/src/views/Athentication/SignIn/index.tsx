import { Box, Button, Card, CardActions, CardContent, TextField } from '@mui/material'
import React, { useState } from 'react'
import axios from 'axios'
import { useCookies } from 'react-cookie';
import { useUserStore } from '../../../stores';

export default function SignIn() {
    const [userEmail, setEmail] = useState<string>('');
    const [userPassword, setPassword] = useState<string>('');
    const [cookies, setCookies] = useCookies();

    const {user, setUser} = useUserStore();

    const signInHandler = () => {
        if (userEmail.length === 0 || userPassword.length === 0) {
            alert('이메일과 비밀번호를 입력하세요.');
            return;
        }

        const data ={
            userEmail,
            userPassword,
        };
        axios
            .post("http://localhost:4000/api/auth/signIn", data)
            .then((response) => {
                const responseData = response.data;
                console.log(responseData);
                if (!responseData.result) {
                    alert('로그인에 실패했습니다.');
                    return;
                }
                const { token, exprTime, user } = responseData.data;
                const expires = new Date();
                expires.setMilliseconds(expires.getMilliseconds + exprTime);                

                setCookies('token', token, { expires });
                setUser(user);
            })
            .catch((error) => {
                alert('로그인에 실패했습니다.');
            });
    };
    return (
    <Card sx={{ minWidth: 275, maxWidth: "50vw" }}>
        { user != null && (<>{user.userNickname}</>)}
        <CardContent>
            <Box>
                <TextField
                    fullWidth
                    label="이메일"
                    type="email"
                    variant="standard"
                    onChange={(e) => setEmail(e.target.value)}
                />
                <TextField
                    fullWidth
                    label="비밀번호"
                    type="password"
                    variant="standard"
                    onChange={(e) => setPassword(e.target.value)}
                />
            </Box>
        </CardContent>
        <CardActions>
            <Button fullWidth onClick={() => signInHandler()} variant="contained">로그인</Button>
        </CardActions>
    </Card>
  )
}
