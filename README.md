<h1>foroHUB - API REST</h1>
    <p><strong>Desarrollado por:</strong> Roldan Nicolas</p>
    <p><strong>Tecnologías utilizadas:</strong> Java, Spring Framework, MySQL, Spring Security</p>

<h2>Descripción del Proyecto</h2>
<p>foroHUB es una API RESTful desarrollada con Java y el framework Spring. El proyecto permite la gestión de tópicos a través de un conjunto de endpoints que permiten realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los mismos. La aplicación incluye autenticación segura mediante tokens JWT, utilizando Spring Security.</p>

<h3>Características principales:</h3>
    <ul>
        <li>CRUD completo de tópicos: crear, leer, actualizar y eliminar tópicos de forma sencilla.</li>
        <li>Autenticación con JWT: la API requiere autenticación para acceder a los endpoints protegidos. Los usuarios pueden iniciar sesión en el endpoint <code>/login</code> proporcionando su usuario y contraseña. Si los datos son correctos, se genera un token JWT que deberá ser utilizado para acceder a los recursos de la API.</li>
        <li>Seguridad con Spring Security: todos los endpoints están protegidos por seguridad basada en roles y autenticación JWT.</li>
        <li>Validaciones y respuestas HTTP: se incluyen validaciones completas en cada método de la API para garantizar la integridad y precisión de las operaciones. Se manejan respuestas HTTP adecuadas para cada situación.</li>
        <li>Pruebas unitarias con JUnit: se han implementado pruebas unitarias para verificar la correcta funcionalidad de los endpoints y las interacciones con la base de datos.</li>
        <li>Conexión a base de datos MySQL: la API está conectada a una base de datos MySQL utilizando los drivers necesarios, lo que permite el almacenamiento persistente de los datos.</li>
       <li><strong>Documentación automática con Spring Doc:</strong> la API incluye documentación generada automáticamente utilizando <strong>Spring Doc</strong>, lo que facilita la consulta de los endpoints disponibles, sus parámetros y las respuestas esperadas. Esta documentación es accesible en el endpoint <code>/swagger-ui</code>.</li>
    </ul>

# Configuración de la base de datos<br>
spring.datasource.url=jdbc:mysql://localhost:3306/foroHub<br>
spring.datasource.username=tu-usuario<br>
spring.datasource.password=tu-contraseña
      



