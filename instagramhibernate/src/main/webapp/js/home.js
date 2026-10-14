let page=0;
async function loadFeed(){
 const posts=await api(`api/posts?page=${page}&size=10`);
 const box=document.getElementById('feed');
 box.innerHTML=posts.map(p=>`
 <div class="card post-card">
  <div class="card-body"><b>@${esc(p.user.username)}</b><span class="muted ms-2">${esc(p.createdAt||'')}</span></div>
  ${p.imageUrl?`<img src="${esc(p.imageUrl)}" class="post-img">`:''}
  <div class="card-body">
   <p>${esc(p.caption)}</p>
   <button class="btn btn-sm btn-outline-danger" onclick="likePost(${p.id},this)">❤️ Like</button>
   <button class="btn btn-sm btn-outline-secondary" onclick="commentPost(${p.id})">💬 Comment</button>
   <button class="btn btn-sm btn-outline-primary" onclick="savePost(${p.id})">🔖 Save</button>
  </div>
 </div>`).join('');
}
async function likePost(id,b){const x=await api('api/likes',{method:'POST',body:enc({postId:id})});b.textContent=x.liked?'💔 Unlike':'❤️ Like';}
async function savePost(id){const x=await api('api/saved',{method:'POST',body:enc({postId:id})});alert(x.saved?'Saved':'Removed from saved');}
async function commentPost(id){const text=prompt('Comment');if(!text)return;await api('api/comments',{method:'POST',body:enc({postId:id,text})});alert('Comment added');}
async function createPost(){const f=document.getElementById('postForm');await api('api/posts',{method:'POST',body:new URLSearchParams(new FormData(f))});f.reset();await loadFeed();}
document.addEventListener('DOMContentLoaded',loadFeed);
