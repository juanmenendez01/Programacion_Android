using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace ApiAndroid.Models;

public partial class EstudiantesContext : DbContext
{
    public EstudiantesContext()
    {
    }

    public EstudiantesContext(DbContextOptions<EstudiantesContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Admin> Admins { get; set; }

    public virtual DbSet<Estudiante> Estudiantes { get; set; }

    public virtual DbSet<Notum> Nota { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Server=localhost; Database=estudiantes; Trusted_Connection=True; TrustServerCertificate=True;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Admin>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__Admins__3213E83FDCFAB814");

            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.Contrasena)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("contrasena");
            entity.Property(e => e.Correo)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("correo");
            entity.Property(e => e.Nombre)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("nombre");
        });

        modelBuilder.Entity<Estudiante>(entity =>
        {
            entity.HasKey(e => e.IdEstudiante).HasName("PK__estudian__E0B2763C1A7F5730");

            entity.ToTable("estudiante");

            entity.Property(e => e.IdEstudiante)
                .ValueGeneratedNever()
                .HasColumnName("id_estudiante");
            entity.Property(e => e.NombreEstudiante)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("nombre_estudiante");
            entity.Property(e => e.ProgramaEstudiante)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("programa_estudiante");
        });

        modelBuilder.Entity<Notum>(entity =>
        {
            entity.HasKey(e => e.IdNota).HasName("PK__nota__26991D8C4EF1DEFC");

            entity.ToTable("nota");

            entity.Property(e => e.IdNota).HasColumnName("id_nota");
            entity.Property(e => e.IdEstudiante).HasColumnName("id_estudiante");
            entity.Property(e => e.NotaFinal)
                .HasColumnType("decimal(4, 2)")
                .HasColumnName("nota_final");

            entity.HasOne(d => d.IdEstudianteNavigation).WithMany(p => p.Nota)
                .HasForeignKey(d => d.IdEstudiante)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("FK_nota_estudiante");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
