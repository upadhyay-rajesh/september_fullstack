async function login(){
 const f=document.getElementById('loginForm'); const d=new FormData(f);
 try{const x=await api('api/login',{method:'POST',body:new URLSearchParams(d)});location.href='home.html';}
 catch(e){document.getElementById('msg').textContent='Invalid username or password';}
}
