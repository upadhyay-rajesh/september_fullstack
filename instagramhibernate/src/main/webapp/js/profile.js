async function loadProfile(){
 const id=new URLSearchParams(location.search).get('id');const u=await api('api/users?id='+id);
 document.getElementById('profile').innerHTML=`<h2>@${esc(u.username)}</h2><h5>${esc(u.fullName)}</h5><p>${esc(u.bio)}</p>`;
}
async function follow(){const id=new URLSearchParams(location.search).get('id');const x=await api('api/follows',{method:'POST',body:enc({userId:id})});document.getElementById('followBtn').textContent=x.following?'Unfollow':'Follow';}
document.addEventListener('DOMContentLoaded',loadProfile);
