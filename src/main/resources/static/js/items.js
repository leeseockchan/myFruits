document.getElementById('itemForm').addEventListener('submit', function(e){
    e.preventDefault();  // 폼 기본 제출 이벤트를 막음

    // FormData 객체를 생성하여 폼 데이터 추가
    const formData = new FormData();
    formData.append('item', document.getElementById('item_name').value);
    formData.append('itemImage', document.getElementById('item_image').files[0]); // 파일 데이터를 추가

    // fetch로 POST 요청
    fetch("/items/create", {
        method: 'POST',
        body: formData  // FormData로 전송
    }).then(response => {
        if (response.ok) {
            alert('아이템이 생성되었습니다.');
            document.getElementById('itemForm').reset();// 폼 리셋
            window.location.href = "/items";// 목록 페이지 이동
        } else {
            alert('아이템 생성에 실패했습니다.');
        }
    }).catch(error => {
        console.error('Error:', error);
        alert('오류가 발생했습니다.');
    });
});

// 사진 미리보기
document.getElementById('item_image').addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('preview').src = e.target.result;  // 미리보기 이미지 설정
        };
        reader.readAsDataURL(file);  // 파일을 읽어 URL로 변환
    }
});
