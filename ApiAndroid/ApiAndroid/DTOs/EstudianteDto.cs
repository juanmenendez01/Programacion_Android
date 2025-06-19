using System.ComponentModel.DataAnnotations;

namespace ApiAndroid.DTOs
{
    public class EstudianteDto
    {
        [Required(ErrorMessage ="El campo es obligatorio")]
        public int IdEstudiante { get; set; }
        [Required(AllowEmptyStrings =false, ErrorMessage ="El campo nombre es obligatorio")]
        public string NombreEstudiante { get; set; } = null!;
        [Required(AllowEmptyStrings = false, ErrorMessage = "El campo nombre es obligatorio")]
        public string ProgramaEstudiante { get; set; } = null!;
        public decimal? NotaEstudiante { get; set; }

    }
}
