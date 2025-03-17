//document.getElementById('itemForm').addEventListener('submit', function(e){
//        e.preventDefault();
//
//        const item = {
//            id: document.getElementById('item_id').value,
//            item: document.getElementById('item_name').value,
//            itemImage: document.getElementById('item_image').value,
//        }
//
//    // fetch( 요청 주소, 요청내용 객체)
//    // 성공
//    // 실패
//    fetch("/items/"+item.id+"/modify", {
//        method: 'post',
//        headers: {'Content-Type': 'application/json'},
//        body: JSON.stringify(item)
//    }).then(response => {
//        if (response.ok) {
//            alert('아이템이 수정되었습니다.');
//            document.getElementById('itemForm').reset();
//            window.location.href = '/items';
//        } else {
//            alert('아이템 수정에 실패했습니다.');
//        }
//    }).catch(error => {
//        console.error('Error:', error);
//        alert('오류가 발생했습니다.');
//    });
//});
////  사진 미리보기
//document.getElementById('item_image').addEventListener('change', function(event) {
//    const file = event.target.files[0];
//    if (file) {
//        const reader = new FileReader();
//        reader.onload = function(e) {
//            document.getElementById('preview').src = e.target.result;
//        };
//        reader.readAsDataURL(file);
//    }
//});

document.getElementById('itemForm').addEventListener('submit', function(e){
    e.preventDefault();

    const item = new FormData();  // FormData 객체를 사용

    item.append('id', document.getElementById('item_id').value);
    item.append('item', document.getElementById('item_name').value);
    item.append('itemImage', document.getElementById('item_image').files[0]);  // 파일 객체를 전달

    // fetch를 사용해 POST 요청
    fetch("/items/" + item.get('id') + "/modify", {
        method: 'POST',
        body: item,  // FormData 객체를 body로 전달
    }).then(response => {
        if (response.ok) {
            alert('아이템이 수정되었습니다.');
            document.getElementById('itemForm').reset();
            window.location.href = '/items';
        } else {
            alert('아이템 수정에 실패했습니다.');
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
            document.getElementById('preview').src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
});
