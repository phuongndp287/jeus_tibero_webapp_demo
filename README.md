# README
## Overview
This project is a responsive and user-friendly **Login Page** developed using `JSP (Java Server Pages)` and styled with modern front-end tools such as **Bootstrap** and **Google Fonts**. It includes basic functionality like email/password fields and a multi-language toggle that currently supports **English (EN)** and **Korean (KR)**.
## Features
### ✔️ Responsive Design
- Built with **Bootstrap 5** for a sleek and modern look across various screen sizes.
- **Mobile-friendly** layout ensures accessibility on any device.

### ✔️ Language Toggle
- Users can switch between **English** and **Korean** languages effortlessly using a **language selector**.
- Labels, placeholders, and other visible texts update dynamically based on the selected language.

### ✔️ Customizable Styling
- **Google Fonts (Poppins)** used for elegant typography.
- Color scheme and spacing implemented with custom CSS for better usability.

### ✔️ Core Elements:
- **Email** and **Password** fields with input validation.
- Prominent **Login Button** styled for user convenience.
- Option to redirect new users to a **Signup Page**.

### ✔️ Dynamic Language Switching with JavaScript
- JavaScript is used for immediate text updates, providing a seamless user experience.

## File Structure
- **HTML/JSP code** renders the login form with required fields and labels.
- **CSS styles** inlined for simplicity, defining layout, spacing, and branding.
- **JavaScript** manages the dynamic language toggle functionality.

## How to Use
### Prerequisites:
1. Ensure you have a Java-based environment supported by your application server (e.g., Apache Tomcat).
2. The project is built using JSP and assumes integration within a web server setup.

### Steps:
1. **Load the JSP into your server**: Ensure the file is located in the appropriate directory as per your server's configuration.
2. **Access the Login Page**: Open a browser and navigate to the respective URL for the login form.
3. **Switch Language**:
    - Use the buttons in the **Language Selector** at the top-right of the page to switch between **English** and **Korean**.

4. **Submit Login**:
    - Enter your email and password, then press the **Login** button.

5. **Redirect to Signup**:
    - If you are a new user, click the **Signup link** to navigate to the signup page.

## Customization
**1. Updating Styles:** Modify the CSS for:
- **Fonts:** Change `font-family` in the `<style>` section.
- **Colors & Layout:** Update background colors or button styles as needed.

**2. Adding More Languages:** Enhance the `changeLanguage` function with additional language keys and translations.
**3. Backend Integration:** Link the form's `action` attribute to your server backend for authentication.
## Dependencies
### Frontend Libraries:
- **Bootstrap 5.3**: For responsive layout and styling.
- **Google Fonts (Poppins)**: For modern typography.

### JavaScript:
- Included as inline `<script>` for dynamic functionality.

## Screenshots
### Desktop Layout:
- A clean and centered login form with prominent features (e.g., login button, language selector).

### Mobile Layout:
- Fully responsive and scaled appropriately for smaller screens.

## Future Enhancements
1. **Add More Languages**:
    - Extend the `languageSelector` to include additional languages.

2. **Forgot Password Functionality**:
    - Add a "Forgot Password" link for user assistance.

3. **Enhance Security**:
    - Implement proper input sanitization and secure form submissions via HTTPS.

## License
This project is open-source and can be freely used and modified as per your needs.
### Support
If you encounter any issues or need help integrating this login page with your project, feel free to reach out. Happy coding! 😊
