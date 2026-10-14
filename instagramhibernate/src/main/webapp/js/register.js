async function register(){
 const f=document.getElementById('registerForm'); const d=new FormData(f);
 try{await api('api/register',{method:'POST',body:new URLSearchParams(d)});alert('Registration successful');location.href='login.html';}
 catch(e){document.getElementById('msg').textContent=e.message;}
}
