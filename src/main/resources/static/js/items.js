document.getElementById('itemForm').addEventListener('submit', function(e){
        e.preventDefault();

        const item = {
            item: document.getElementById('item_id').value
        };
//        이미지 생성 메소드
 function updateImage() {
        let itemName = document.getElementById("item_id").value;
        document.getElementById("itemImage").src = "/images/" + itemName + ".jpg";
    }
    // 이미지 업데이트 호출
    updateImage();

    // fetch( 요청 주소, 요청내용 객체)
    // 성공
    // 실패
    fetch("/items", {
        method: 'post',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(item)
    }).then(response => {
        if (response.ok) {
            alert('아이템이 생성되었습니다.');
            document.getElementById('itemForm').reset();
        } else {
            alert('아이템 생성에 실패했습니다.');
        }
    }).catch(error => {
        console.error('Error:', error);
        alert('오류가 발생했습니다.');
    });
});