using System.ComponentModel.DataAnnotations;

namespace ApiAndroid.DTOs
{
    public class AdminDto
    {
        public int Id { get; set; }

        public string Nombre { get; set; } = null!;

        [Required(ErrorMessage ="El campo no debe estar vacio")]
        public string? Correo { get; set; } = null!;

        [Required(ErrorMessage = "El campo no debe estar vacio")]
        public string? Contrasena { get; set; } = null!;
    }
}
