<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background: white;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        .form-control {
            border-radius: 8px;
        }
        .btn-primary {
            border-radius: 8px;
            font-weight: 600;
        }
        .new_to_site {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: center;
            gap: 12px;
        }
        .language-selector {
            position: absolute;
            top: 15px;
            right: 15px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="language-selector" id="languageSelector">
    <button class="btn btn-link" onclick="changeLanguage('en')">EN</button>
    <button class="btn btn-link" onclick="changeLanguage('kr')">KR</button>
</div>
<div class="login-container">
    <!-- Thêm logo phía trên tiêu đề Login -->
    <div class="text-center mb-4">
        <img src="images/tmaxsoftLogo.png" alt="Logo" style="max-width: 150px; margin-bottom: 10px;">
    </div>

    <form action="login" method="get">
        <div class="mb-3">
            <label for="email" class="form-label" id="emailLabel">Email</label>
            <input type="email" id="email" class="form-control" placeholder="Enter your email" required name="email">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label" id="passwordLabel">Password</label>
            <input type="password" id="password" class="form-control" placeholder="Enter your password" required name="password">
        </div>
        <button type="submit" class="btn btn-primary w-100" id="loginButton">Login</button>
        <p class="new_to_site" id="newToSiteText">New to site? <span><a href="signup">Signup</a></span></p>
    </form>
</div>

<script>
    function changeLanguage(lang) {
        const elements = {
            'loginHeader': {
                'en': 'Login',
                'kr': '로그인' // Korean translation
            },
            'emailLabel': {
                'en': 'Email',
                'kr': '이메일' // Korean translation
            },
            'passwordLabel': {
                'en': 'Password',
                'kr': '비밀번호' // Korean translation
            },
            'loginButton': {
                'en': 'Login',
                'kr': '로그인' // Korean translation
            },
            'newToSiteText': {
                'en': 'New to site?',
                'kr': '새 사용자인가요?' // Korean translation
            }
        };

        // Duyệt qua tất cả phần tử và thay đổi ngôn ngữ (nếu phần tử tồn tại)
        for (const [key, value] of Object.entries(elements)) {
            const element = document.getElementById(key);
            if (element) { // Chỉ thay đổi nếu phần tử tồn tại
                element.textContent = value[lang];
            }
        }

        // Cập nhật các placeholder (nếu phần tử tồn tại)
        const emailElement = document.getElementById('email');
        const passwordElement = document.getElementById('password');
        if (emailElement && passwordElement) {
            if (lang === 'en') {
                emailElement.placeholder = 'Enter your email';
                passwordElement.placeholder = 'Enter your password';
            } else if (lang === 'kr') {
                emailElement.placeholder = '이메일을 입력하세요';
                passwordElement.placeholder = '비밀번호를 입력하세요';
            }
        }
    }
</script>
</body>
</html>
