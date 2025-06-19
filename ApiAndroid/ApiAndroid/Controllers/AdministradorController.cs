using ApiAndroid.DTOs;
using ApiAndroid.Models;
using Microsoft.AspNetCore.Mvc;

namespace ApiAndroid.Controllers
{
    [ApiController]
    [Route("proyectoFinal")]
    public class AdministradorController : ControllerBase
    {
        private readonly EstudiantesContext _context;
        public AdministradorController(EstudiantesContext context) {
            
            _context = context;
        }
        [HttpPost]
        [Route("Administrador")]
        public IActionResult Login([FromBody] AdminDto admin)
        {
            var LoginAdmin = _context.Admins.Where(e=>e.Correo == admin.Correo && e.Contrasena == admin.Contrasena).FirstOrDefault();

            if (LoginAdmin != null)
            {
                return Ok(LoginAdmin);
            }

            var mensaje = "usuario no encontrado";
            return NotFound(mensaje);
        }
    }
}
