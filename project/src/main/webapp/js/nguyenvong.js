//load Nganh
$.ajax({
    url: "/nganhs",
    type: "GET",
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (data) {
        for (const x in data) {
            $("#idnganh").append(new Option(data[x].tenNganh, data[x].id));
        }
    },
});
var dataTable = [];
$(document).ready(function () {

    function getmaToHopMon(idToHopMon){
        var data = {"id":idToHopMon};
        $.ajax({
            url: "/tohopmon",
            type: "GET",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
               return data.maToHopMon;
            },
        });
    }
    
    $.ajax({
        url: "/nguyenvongs",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            dataTable = data;
            $('#example').DataTable( {
                data: dataTable, 
                columns: [
                        { "data": "id" },
                        { "data": "idToHopMon" },
                        { "data": "diemtbMonMot" },
                        { "data": "diemtbMonHai" },
                        { "data": "diemtbMonBa" },
                ]
            });
        },
    });

    $('#idnganh').on('change', function() {
        var data = {"idNganh":this.value};
        $.ajax({
            url: "/tohopmonnganh",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                for (const x in data) {
                    $("#idToHopMon").append(new Option(data[x].maToHopMon, data[x].id));
                }
            },
        });
    });
    function loadData() {
        // Load ho so
        $.ajax({
            url: "/hoso",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                if (data.id != null) {
                    for (const [key, value] of Object.entries(data)) {
                        $("input[name='" + key + "']").val(value);
                        //$("option[name='"+ key +"']").val(value);
                        $("select[name^=" + key + "] option[value=" + value + "]").attr(
                            "selected",
                            "selected"
                        );
                    }
                    $("input[name='ngaySinh']").val(
                        new Date(data.ngaySinh + 3600 * 1000 * 24).toJSON().split("T")[0]
                    );
                    $(".form-control").prop("disabled", true);
                }

                // for (const x in data) {
                // 	text += data[x] + ", ";
                // 	$("input[name='']").val("your value");
                //   }
            },
        });
    }
    //loadData();

    $("#formhoso").extend(jQuery.validator.messages, {
        required: "Trường Không được bỏ trống. Vui lòng Điền Chính Xác Giá Trị",
    });

    $("#formhoso")
        .submit(function (e) {
            e.preventDefault();
        })
        .validate({
            onfocusout: false,
            onkeyup: false,
            onclick: false,
            rules: {
                hoTen: {
                    required: true,
                    maxlength: 60,
                },
                cccd: {
                    required: true,
                    maxlength: 12,
                    minlength: 12,
                },
                ngaySinh: {
                    required: true,
                },
                gioiTinh: {
                    required: true,
                },
                soDienThoai: {
                    required: true,
                    maxlength: 10,
                    minlength: 10,
                },
                diaChi: {
                    required: true,
                },
                soDienThoaiBo: {
                    required: true,
                    maxlength: 10,
                    minlength: 10,
                },
                soDienThoaiMe: {
                    required: true,
                    maxlength: 10,
                    minlength: 10,
                },
                doiTuongUuTien: {
                    required: true,
                },
                khuVucUuTien: {
                    required: true,
                },
                idTruongThpt10: {
                    required: true,
                },
                idTruongThpt11: {
                    required: true,
                },
                idTruongThpt12: {
                    required: true,
                },
            },
            messages: {
                hoTen: {
                    required: "Bắt buộc nhập username",
                    maxlength: "Hãy nhập tối đa 15 ký tự",
                },
                cccd: {
                    required: "Bắt buộc nhập cccd",
                    minlength: "Nhập đúng số cccd 12 chữ số",
                    maxlength: "Nhập đúng số cccd 12 chữ số",
                },
                soDienThoai: {
                    required: "Vui Lòng Nhập Đúng Số Điện Thoại",
                    maxlength: "Vui Lòng Nhập Đúng Số Điện Thoại Của Bạn",
                    minlength: "Vui Lòng Nhập Đúng Số Điện Thoại Của Bạn",
                },
                soDienThoaiBo: {
                    required: "Vui Lòng Nhập Đúng Số Điện Thoại",
                    maxlength: "Vui Lòng Nhập Đúng Số Điện Thoại",
                    minlength: "Vui Lòng Nhập Đúng Số Điện Thoại",
                },
                soDienThoaiMe: {
                    required: "Vui Lòng Nhập Đúng Số Điện Thoại",
                    maxlength: "Vui Lòng Nhập Đúng Số Điện Thoại",
                    minlength: "Vui Lòng Nhập Đúng Số Điện Thoại",
                },
            },
            submitHandler: function (form) {
                var formdata = $("#formhoso").serializeArray();
                var data = {};
                $(formdata).each(function (index, obj) {
                    data[obj.name] = obj.value;
                });

                if (data.id == "") {
                    $.ajax({
                        url: "/hoso",
                        type: "POST",
                        data: JSON.stringify(data),
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (data) {
                            console.log("SUCCESS : ", data.kq);
                            if (data.kq == "ok") {
                                alert("Bạn lưu thành công");
                            } else {
                                alert("Bạn lưu không thành công");
                            }
                        },
                        error: function (e) {
                            console.log("ERROR : ", e);
                        },
                    });
                    myCancel();
                } else {
                    $.ajax({
                        url: "/hoso",
                        type: "PUT",
                        data: JSON.stringify(data),
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (data) {
                            console.log("SUCCESS : ", data.kq);
                            if (data.kq == "ok") {
                                alert("Bạn cập nhập thành công");
                            } else {
                                alert("Bạn cập nhập không thành công");
                            }
                        },
                        error: function (e) {
                            console.log("ERROR : ", e);
                        },
                    });
                    myCancel();
                }
                return false;
            },
        });
});
